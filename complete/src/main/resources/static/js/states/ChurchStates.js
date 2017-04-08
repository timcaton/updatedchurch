angular.module('church-app')
    .config(['stateHelperProvider', function(stateHelperProvider) {
        stateHelperProvider.state({
            name: 'member',
            url: '/member',
            pageTitle: 'Member Maintenance',
            templateUrl: 'components/member.html'
        });
}]);