angular.module('church-app')
    .config(['stateHelperProvider', function(stateHelperProvider) {
        stateHelperProvider.state({
            name: 'member',
            url: '/member',
            controller: 'MemberController',
            pageTitle: 'Member Maintenance',
            templateUrl: 'partials/member.ftl'
        });
}]);