const emailSender = state => {
    return {
        sendEmail() {
            console.log(`send email to  ${state.name}`);
        }
    }
};

const smsSender = state => ({
    sendSms() {
        console.log(`send sms to  ${state.name}`);
    }
})

const sender = () => {
    let state = {
        name: 'John'
    }
    return Object.assign(state, emailSender(state), smsSender(state));
}

function main() {
    console.log(sender())
    sender().sendEmail()
}

main()