'use strict';

/**
 * PesticideController
 * @constructor
 */
var PesticideController = function($scope, $http) {
    $scope.pesticide = {};
    $scope.editMode = false;

    $scope.fetchPesticidesList = function() {
        $http.get('pesticides/pesticideslist.json').success(function(pesticideList){
            $scope.pesticides = pesticideList;
        });
    }

    $scope.addNewPesticide = function(pesticide) {
        $scope.resetError();

        $http.post('pesticides/addPesticide', pesticide).success(function() {
            $scope.fetchPesticidesList();
            $scope.pesticide.name = '';
          //  $scope.pesticide.speed = ''; //TODO add pesticide fields
          //  $scope.pesticide.diesel = false;
        }).error(function() {
            $scope.setError('Could not add a new pesticide');
        });
    }

    $scope.updatePesticide = function(pesticide) {
        $scope.resetError();

        $http.put('pesticides/updatePesticide', pesticide).success(function() {
            $scope.fetchPesticidesList();
            $scope.pesticide.name = '';
         // $scope.pesticide.speed = '';
         // $scope.pesticide.diesel = false;
            $scope.editMode = false;
        }).error(function() {
            $scope.setError('Could not update the pesticide');
        });
    }

    $scope.editPesticide = function(pesticide) {
        $scope.resetError();
        $scope.pesticide = pesticide;
        $scope.editMode = true;
    }

    $scope.removePesticide = function(id) {
        $scope.resetError();

        $http.delete('pesticides/removePesticide/' + id).success(function() {
            $scope.fetchPesticidesList();
        }).error(function() {
            $scope.setError('Could not remove pesticide');
        });
    }

    $scope.removeAllPesticides = function() {
        $scope.resetError();

        $http.delete('pesticides/removeAllPesticides').success(function() {
            $scope.fetchPesticidesList();
        }).error(function() {
            $scope.setError('Could not remove all pesticides');
        });

    };

    $scope.resetPesticideForm = function() {
        $scope.resetError();
        $scope.pesticide = {};
        $scope.editMode = false;
    }

    $scope.resetError = function() {
        $scope.error = false;
        $scope.errorMessage = '';
    }

    $scope.setError = function(message) {
        $scope.error = true;
        $scope.errorMessage = message;
    }

    $scope.fetchPesticidesList();

    $scope.predicate = 'id';
}

