
const serverErrorInputService = function (customReasons) {
    console.log('*->', customReasons)
    return {
        handleErrorForms: (fieldErrors) => {
            return fieldErrors.reduce((acc, val) => {
                const key = Object.keys(customReasons)
                    .find(key => new RegExp(key).test(val.reason));
                acc[val.field] = key ? customReasons[key] : val.reason;
                return acc;
            }, {});
        }
    }
};

const inventoryErrorServiceFormsError = (customReasons, serverErrorInputService) => {
    // ideally to merge customReason into serverErrorInputService, Angular didn't like it, 
    // passing by angular.value
    customReasons['longDescription with value.*'] = 'There was a problem saving. ' +
            'The Long Description field exceeds the number of characters permitted. ' +
            'Reduce the number of characters in the Long Description field and try saving again.';
            //angular.extend(ChildService.prototype, BaseService);
    return  Object.assign({}, serverErrorInputService);
};

const reportsErrorService = () => {
    const customReasons = {
        'name.*must be unique': 'Name must be unique'
    };
    return angular.extend({}, {customReasons});
}

const mainController = (inventoryErrorServiceFormsError, reportsErrorService) => {
    const errors = [
        {
            "field": "name",
            "reason": "name with value bob must be unique"
        },
        {
            "field": "desc",
            "reason": "longDescription with value"
        }

    ];
    console.log('******', inventoryErrorServiceFormsError)
    console.log(inventoryErrorServiceFormsError.handleErrorForms(errors))
  //  console.log(reportsErrorService.handleServerError(errors))
}

angular
    .module("app", [])
    .controller('mainController', mainController)
    .factory('inventoryErrorServiceFormsError', inventoryErrorServiceFormsError)
    .factory('reportsErrorService', reportsErrorService)
    .factory('serverErrorInputService', serverErrorInputService)
    .value('customReasons', {})