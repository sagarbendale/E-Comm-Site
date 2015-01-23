  var app = angular.module('ecomProject273', ['ui.router']);
  app.config(function($stateProvider, $urlRouterProvider)
  	$urlRouterProvider.otherwise("/store/");
      $stateProvider
      .state('root',{
        	url: '/store',
        	abstract: true,
        	views: {
          	'left-side': {
            		templateUrl: 'views/left-pane.html'
          	}
        	}
      })
      .state('root.products', {
        	url: '/:catid',
        	views: {
          	'main-body@': {
            		templateUrl: 'views/target.html',
            		controller: 'productsController'
          	}
        	}
      })
      .state('root.product', {
        	url: '/:catid/:pid',
        	views: {
          	'main-body@': {
            		templateUrl : 'views/target1.html',
            		controller : 'oneProductController'
          	}
        	}
      });
  });
  app.run(function ($rootScope, $state, $stateParams, $http) {
  	$http.get('/store/request/service/Type').success(function(data){
  		$rootScope.categories = data;
      $scope.products=data;
  		$state.transitionTo('root.products', {catid: ''});
  	});
  });
  app.controller('productsController', function($scope, $http, $stateParams){
  	$scope.catID = $stateParams.catid;
  	$http.get('/store/'+$stateParams.catid).success(function(data){
  		$scope.products = data;
  	});
  });
  app.controller('oneProductController', function($scope, $http, $stateParams){
  	var pid = $stateParams.pid;
    var catid = $stateParams.catid;
  	$http.get('/store/'+catid+'/'+pid).success(function(data){
  		$scope.product = data;
  }
       