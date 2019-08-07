(function () {
    'use strict';

    angular
        .module('app', [
            'app.layout'
        ]).run(function($state, logger) {
            // The $state injection is a workaround fix for https://github.com/angular-ui/ui-router/issues/679
            logger.debug('Defined states: ', $state.get().length);
        });
})();
