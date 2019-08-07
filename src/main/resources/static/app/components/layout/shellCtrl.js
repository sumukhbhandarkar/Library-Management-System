(function () {
    'use strict';

    angular
        .module('app.layout')
        .controller('Shell', Shell);

    function Shell(appSettings, appStarterService) {
        /*jshint validthis: true */
        var vm = this;

        vm.busyMessage = 'Please wait ...';
        vm.isBusy = true;
        vm.showSplash = true;
        vm.appName = appSettings.config.appName;
        vm.containerClass = appSettings.config.isFluid ? 'container-fluid' : 'container';

        activate();

        ////////////////

        function activate() {
            appStarterService.getPrimePromise().then(hideSplash).catch(fatalError);
        }

        function fatalError() {
            vm.showSplash = false;
            vm.fatalError = true;
        }

        function hideSplash() {
            vm.showSplash = false;
        }
    }
})();
