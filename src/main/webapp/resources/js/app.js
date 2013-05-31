'use strict';

var AngularSpringApp = {};

var App = angular.module('AngularSpringApp', ['AngularSpringApp.filters', 'AngularSpringApp.services', 'AngularSpringApp.directives']);

angular.module('app', ['ngUpload'])
.controller('mainCtrl', function($scope) {
  $scope.results = function(content, completed) {
    if (completed && content.length > 0)
      console.log(content); // process content
    else
    {
      // 1. ignore content and adjust your model to show/hide UI snippets; or
      // 2. show content as an _operation progress_ information
    }
  }
});

      
// Declare app level module which depends on filters, and services
App.config(['$routeProvider', function ($routeProvider) {

    $routeProvider.when('/cars', {
        templateUrl: 'cars/layout',
        controller: CarController
    });

    $routeProvider.when('/trains', {
        templateUrl: 'trains/layout',
        controller: TrainController
    });
    
    $routeProvider.when('/railwaystations', {
        templateUrl: 'railwaystations/layout',
        controller: RailwayStationController
    });

    $routeProvider.when('/menus', {
        templateUrl: 'menus/list',
        controller: MenuController
    });
    $routeProvider.when('/pesticides', {
        templateUrl: 'pesticides/layout',
        controller: PesticideController
    });
    
  /*  $routeProvider.when('/menus/:menuId', {
    	controller: MenuDetailController,
        templateUrl: 'menus/view'
    });
    */
    
    $routeProvider.otherwise({redirectTo: '/cars'});
}]);
