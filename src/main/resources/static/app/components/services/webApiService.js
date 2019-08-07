(function () {
    'use strict';

    angular
        .module('app.services')
        .factory('webApiService', refreshService);

    function refreshService($http, $q) {

        var service = {
            getAllBooksData: getAllBooksData,
            issueBooks: issueBooks,
            returnBooks: returnBooks,
            updateBookLocation: updateBookLocation,
            getBookHistory: getBookHistory
        };

        return service;

        function getAPIRoot() {
            return "localhost:8585/api/"
        }

        function getAllBooksData(params) {
            return $http.get(getAPIRoot() + '/get', {params: params});
        }

        function getBookHistory(params) {
            return $http.get(getAPIRoot() + '/history', {params: params});
        }

        function issueBooks(params) {
            return $http.post(getAPIRoot() + '/issueBooks', {params: params});
        }

        function returnBooks(params) {
            return $http.post(getAPIRoot() + '/returnBooks', {params: params});
        }

        function updateBookLocation(params) {
            return $http.post(getAPIRoot() + '/updateBook', {params: params});
        }
     }
})
();
