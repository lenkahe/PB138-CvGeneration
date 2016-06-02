var showCV = angular.module('showCV', []);

showCV.controller('formController', ['$scope', '$window', '$http', function ($scope, $window, $http) {
    $scope.deleteItem = function (array, index) {
        if (array.length === 1) {
            array.splice(0, 1);
        } else if (array.length > 1) {
            array.splice(index, 1);
        }
    };
}