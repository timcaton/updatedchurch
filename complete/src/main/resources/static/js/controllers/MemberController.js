churchController.controller('MemberController', ['$scope', 'ChurchMemberService', '$controller', 'appConfig','$filter',
    function ($scope, churchMemberService, $controller,appConfig,$filter) {

        $controller('BaseController', {$scope: $scope});

        $scope.member = {};
        $scope.members = [];

        $scope.init = function () {
            $scope.loadGrid();
        };

        var dataToSelect = {};
        $scope.rowSelect = function (entity) {
            $scope.isOpen = true;
            churchMemberService.getById({id: entity.id}).then(function (member) {
                $scope.isMemberSelected = true;
                dataToSelect = member;
                $scope.member = dataToSelect;
                dataToSelect = {};
                $scope.memberForm.$pristine = false;
                $scope.memberForm.$dirty = true;
            });
        };

        $scope.getMembers = function () {
            churchMemberService.getAll().then(function (response) {
                $scope.members = response;
                $scope.memberGrid.data =  $scope.buildMemberGridData();
            }, function (errResponse) {
                //alert
            });
        };

        $scope.buildMemberGridData = function () {
            var gridArray = [];
            angular.forEach($scope.members, function (value) {
                var gridObject = {};
                gridObject.id = value.id;
                gridObject.firstName = value.firstName;
                gridArray.push(gridObject);
            });
            return gridArray;
        };

        $scope.saveMember = function () {
            var memberToCreate = $scope.buildMember();
            memberToCreate.id = null;
            churchMemberService.create(memberToCreate).then(function () {
                $scope.resetForm();
                $scope.getMembers();
                //show success
            }, function (errResponse) {
                //alert
            });
        };

        $scope.buildMember = function () {
            var memberToCreate = {};
            angular.forEach($scope.member, function (value, key) {
                memberToCreate[key] = value;
            });
            return memberToCreate;
        };

        $scope.deleteMember = function () {
            var param = {id: $scope.member.id};
            churchMemberService.delete(param).then(function () {
                $scope.resetForm();
                $scope.members = [];
                $scope.memberGrid.data = [];
                $scope.getMembers();
                //show success
            }, function (errResponse) {
                //error
            });
        };

        $scope.updateMember = function () {
            var memberToUpdate = $scope.buildMember();
            churchMemberService.update({id: memberToUpdate.id}, memberToUpdate).then(function () {
                $scope.resetForm();
                $scope.getMembers();
                //success
            }, function (errResponse) {
                //error
            });
        };

        var columns = [
            {
                name: 'firstName',
                displayName: 'First Name',
                enableSorting: true,
                enableCellEdit: false,
                width:'10%',
                cellTemplate: '<div class="descGrid">{{COL_FIELD}}</div>'
            },
            {
                name: 'lastName',
                displayName: 'Last Name',
                enableSorting: true,
                enableCellEdit: false,
                width:'10%',
                cellTemplate: '<div class="descGrid">{{COL_FIELD}}</div>'
            }
        ];

        $scope.loadGrid = function () {
            $scope.memberGrid = {
                rowHeight: 60,
                enableFiltering: false,
                enableFullRowSelection: true,
                enableSelectionBatchEvent: true,
                enablePaginationControls: false,
                multiSelect: false,
                noUnselect: true,
                enableSorting: true,
                enableGridMenu: true,
                enableRowHeaderSelection: false,
                columnDefs: columns,
                onRegisterApi: function (gridApi) {
                    $scope.gridApi = gridApi;
                    gridApi.selection.on.rowSelectionChanged($scope, function (row) {
                        $scope.rowSelect(row.entity);
                    });
                }
            };
        };

        $scope.resetForm = function () {
            $scope.formErrors = [];
            $scope.memberForm.$setUntouched();
            $scope.memberForm.$setPristine();
            $scope.isMemberSelected = false;
            $scope.memberForm.$dirty = false;
            $scope.member = {};
            $scope.members = [];
            $scope.memberGrid.data = [];
            $scope.gridApi.selection.clearSelectedRows();
            $scope.gridApi.grid.clearAllFilters();
            $scope.memberForm.$submitted = false;
        };

        $scope.isAddDisable = function () {
            return $scope.memberForm.$pristine;
        };

        $scope.isUpdateOrDeleteDisable = function () {
            var isDisable = false;
            if (!$scope.isMemberSelected) {
                isDisable = true;
            } else if ($scope.memberForm.$pristine) {
                isDisable = true;
            }
            return isDisable;
        };

        $scope.multiselectSettings = {
            externalIdProp: ''
        };

        $scope.init();
    }]);