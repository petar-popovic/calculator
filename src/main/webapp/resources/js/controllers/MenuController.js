'use strict';

/**
 * MenuController
 * @constructor
 */
var MenuController = function($scope, $http) {
    $scope.menu = {};
    $scope.page = {};
    $scope.updatePage = {};
    $scope.editMode = false;
    $scope.previousMenu = {};

    $scope.fetchMenusList = function() {
        $http.get('menus/menuslist.json').success(function(menuList){
            $scope.menus = menuList;
        });
    }
    
    $scope.fetchOrdersList = function() {
        $http.get('menus/orderslist.json').success(function(orderList){
            $scope.orders = orderList;
        });
    }

    $scope.addNewMenu = function(menu) {
        $scope.resetError();

        $http.post('menus/addMenu', menu).success(function() {
            $scope.fetchMenusList();
            $scope.menu.name = '';
            $scope.menu.orderId = '';
        }).error(function() {
            $scope.setError('Could not add a new menu');
        });
    }
    
    $scope.addNewMenuPage = function(menuId, page) {
        $scope.resetError();

        $http.post('menus/'+menuId+'/addPage', page).success(function() {
            $scope.fetchMenusList();
            $scope.page.name = '';
            $scope.page.orderId = '';
        }).error(function() {
            $scope.setError('Could not add a new pae');
        });
    }


    $scope.updateMenu = function(menu) {
        $scope.resetError();

        $http.put('menus/updateMenu', menu).success(function() {
            $scope.fetchMenusList();
            $scope.menu.name = '';
            $scope.menu.orderId = '';
            $scope.editMode = false;
        }).error(function() {
            $scope.setError('Could not update the menu');
        });
    }
    
    $scope.updateMenuPage = function(menuId, page) {
        $scope.resetError();

        $http.put('menus/'+menuId+'/updatePage', page).success(function() {
            $scope.fetchMenusList();
          //  page.name = '';
           // page.orderId = '';
            page.editMode = false;
        }).error(function() {
            $scope.setError('Could not update the page');
        });
    }

    $scope.editMenu = function(menu) {
        $scope.resetError();
        $scope.menu = menu;
        $scope.editMode = true;
    }
    
    $scope.editPage = function(page) {
        $scope.resetError();
        page.editMode = true;
        if( $scope.updatePage != null)
        	$scope.updatePage.editMode = false;
        $scope.updatePage = page;
        $scope.updatePage.editMode = true;
    }
    
    $scope.editMenuForPageAdding = function(menu){
    	$scope.previousMenu.editMode = false;
    	menu.editMode = true;
    	$scope.previousMenu = menu;
    }

    $scope.removeMenu = function(id) {
        $scope.resetError();

        $http.delete('menus/removeMenu/' + id).success(function() {
            $scope.fetchMenusList();
        }).error(function() {
            $scope.setError('Could not remove menu');
        });
    }

    $scope.removeAllMenus = function() {
        $scope.resetError();

        $http.delete('menus/removeAllMenus').success(function() {
            $scope.fetchMenusList();
        }).error(function() {
            $scope.setError('Could not remove all menus');
        });

    };

    $scope.resetMenuForm = function() {
        $scope.resetError();
        $scope.menu = {};
        $scope.editMode = false;
    }
    
    $scope.resetMenuPageForm = function(page){
    	page.name = ""; //TODO dodati i ostala polja koja se resetuju
    }

    $scope.resetError = function() {
        $scope.error = false;
        $scope.errorMessage = '';
    }

    $scope.setError = function(message) {
        $scope.error = true;
        $scope.errorMessage = message;
    }

    $scope.fetchMenusList();
    $scope.fetchOrdersList();

    $scope.predicate = 'id';
}