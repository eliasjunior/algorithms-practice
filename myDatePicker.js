function myCalendar() {
  const WEEK_DAY_VALUE = { 0: 'SUN', 1: 'MON', 2: 'TUE', 3: 'WED', 4: 'THU', 5: 'FRI', 6: 'SAT' };
  const WEEK_DAYS = ['SUN', 'MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT'];

  let currentDate;

  return {
    buildCalendar() {
      let now = this.getDate();
      let dayOfMonth = now.getDate();
      let dayOfWeek = now.getDay();

      //get day of the month
      let remainder = dayOfMonth;
      while (remainder >= 7) {
        remainder -= 7
      }
      const index = WEEK_DAYS.findIndex(day => day === WEEK_DAY_VALUE[dayOfWeek]);

      let firstDay = index - (remainder - 1);

      if (firstDay < 0) {
        firstDay = this.getFirstDayMonthBackWords(index, remainder);
      }

      let indexFirstDay = WEEK_DAYS.findIndex(day => day === WEEK_DAYS[firstDay]);

      console.log('Dia primeiro do mes', WEEK_DAYS[firstDay], indexFirstDay);

      let countDay = 1;
      let htmlCalendar = '<tr>';
      let line = 1;
      let countRunnerTemp = 0;
      let lastDayPreviousMonth = this.getPreviousMonthDay(now);
      let previousMonthDaysStack = [];

      while (countDay <= this.monthLastDay(now)) {
        if (line < 8) {
          if (countRunnerTemp < indexFirstDay) {
            previousMonthDaysStack.push(lastDayPreviousMonth);
            lastDayPreviousMonth -= 1;
          } else {
            if (previousMonthDaysStack.length > 0) {
              while (previousMonthDaysStack.length) {
                const day = previousMonthDaysStack.pop();
                htmlCalendar = htmlCalendar
                  .concat('<td class="previous-day"> ')
                  .concat(day)
                  .concat('</td>');
              }
            }

            let classSelectedDay = '';

            if (countDay === dayOfMonth) {
              classSelectedDay = 'dayFocus'
            }

            htmlCalendar = htmlCalendar
              .concat('<td class="' + classSelectedDay + '">')
              .concat(countDay.toString())
              .concat('</td>');

            countDay += 1;

          }
          line += 1;

        } else {
          htmlCalendar = htmlCalendar.concat('<tr>');
          line = 1;
        }
        countRunnerTemp += 1
      }
      htmlCalendar = htmlCalendar.concat('</tr>');

      return htmlCalendar;
    },
    getFirstDayMonthBackWords(indexWeekDay, remainder) {
      //walk backwords
      let i = indexWeekDay;
      while (remainder > 1) {
        if (i === 0) {
          i = WEEK_DAYS.length - 1
        } else {
          i -= 1;
        }
        remainder -= 1;
      }
      return WEEK_DAYS.findIndex((day) => day === WEEK_DAY_VALUE[i])
    },
    getPreviousMonthDay(currentDate) {
      let previousDate = new Date(currentDate.getFullYear(),
        currentDate.getMonth() - 1,
        currentDate.getDate());
      const ROLL_BACK_DAY = 0;

      const lastDayPreviousMonth =
        new Date(previousDate.getFullYear(),
          previousDate.getMonth() + 1,
          ROLL_BACK_DAY);

      return lastDayPreviousMonth.getDate();
    },
    setDate(dateParam) {
      currentDate = dateParam
    },
    getDate() {
      return currentDate;
    },
    monthLastDay(currentDate) {
      const ROLL_BACK_DAY = 0;
      const lastDayMonth =
        new Date(currentDate.getFullYear(), currentDate.getMonth() + 1, ROLL_BACK_DAY);
      return lastDayMonth.getDate();
    },
    monthLabel() {
      //only 28 for the moment
      return {
        0: 'JAN',
        1: 'FEV',
        2: 'MAR',
        3: 'APR',
        4: 'MAY',
        5: 'JUN',
        6: 'JUL',
        7: 'AUG',
        8: 'SET',
        9: 'OUT',
        10: 'NOV',
        11: 'DEC'
      }
    },
    nextMonth(options) {
      const myDate = options.currentDate;
      myDate.setMonth(myDate.getMonth() + 1);
    },
    previousMonth(options) {
      const myDate = options.currentDate;
      myDate.setMonth(myDate.getMonth() - 1);
    },
    getHeader() {
      return ''.concat('<tr class="header">')
        .concat('<td>S</td>')
        .concat('<td>M</td>')
        .concat('<td>T</td>')
        .concat('<td>W</td>')
        .concat('<td>T</td>')
        .concat('<td>F</td>')
        .concat('<td>S</td>')
        .concat('</tr>');
    }
  }
}

function createCalendar(calendar) {
  const header = calendar.getHeader();
  const body = calendar.buildCalendar();

  $('#calendar').html(header.concat(body));
  const monthLabel = calendar.monthLabel()[calendar.getDate().getMonth()];
  const year = calendar.getDate().getFullYear();
  $('#monthLabel').html(monthLabel.concat('-').concat(year));
}

function init() {
  let calendar = myCalendar();
  calendar.setDate(new Date());

  createCalendar(calendar);

  const eventNext = (event) => {
    calendar.nextMonth(event.data);
    createCalendar(calendar);
  };
  const previousNext = (event) => {
    calendar.previousMonth(event.data);
    createCalendar(calendar);
  };

  $('#next').click({ currentDate: calendar.getDate() }, eventNext);
  $('#previous').click({ currentDate: calendar.getDate() }, previousNext);
}

$(document).ready(function () {
  init();
});

