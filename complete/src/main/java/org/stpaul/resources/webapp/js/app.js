var churchApp = angular.module('church-app', ['ui.router', 'ui.router.stateHelper', 'ngAnimate', 'ngCookies', 'ngResource', 'ngStorage', 'church-utility', 'church-controller',
    'church-service', 'church-directive', 'ui.bootstrap', 'app-config', 'common-directives', 'common-controller', 'common-services', 'utility', 'security', 'user-profile', 'ui.grid',
    'ui.grid.pagination', 'ui.grid.selection', 'ui.grid.edit', 'ui.grid.rowEdit', 'ui.grid.cellNav', 'ui.grid.exporter', 'common-filter']);

churchApp.config(['stateHelperProvider', '$urlRouterProvider', '$urlMatcherFactoryProvider', function (stateHelperProvider, $urlRouterProvider, $urlMatcherFactoryProvider) {
    $urlRouterProvider.otherwise("/");

    $urlMatcherFactoryProvider.strictMode(false);

}]).run(function ($rootScope, utilityService) {
    $rootScope.utility = utilityService;
});

churchApp.config(['stateHelperProvider', '$urlRouterProvider', '$urlMatcherFactoryProvider', '$httpProvider',
    function (stateHelperProvider, $urlRouterProvider, $urlMatcherFactoryProvider, $httpProvider) {

        $httpProvider.interceptors.push('unauthorizedHandler');
        $urlRouterProvider.otherwise("/home");
        $urlMatcherFactoryProvider.strictMode(false);

        stateHelperProvider.state({
            name: "home",
            url: "/home",
            templateUrl: "components/index.ftl"
        }).state({
            name: "login",
            url: "/login",
            templateUrl: "components/login/login.html",
            controller: "LoginController"
        }).state({
            name: "forbidden",
            url: "/forbidden",
            templateUrl: "components/login/forbidden.html"
        }).state({
            name: "unauthorized",
            url: "/unauthorized",
            templateUrl: "components/login/unauthorized.html"
        });
    }]).run(securityConfig);