cappingService.factory('CapService', function ($resource) {
    return $resource('api/caps/:id', {}, {
        'getAll': {method: 'GET', isArray: true}
    });
});