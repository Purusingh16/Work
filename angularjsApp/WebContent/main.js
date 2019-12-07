// main.js
var app = angular.module('myApp', ['ngGrid']);

app.controller('MyCtrl', function($scope, $http) {
  $scope.mySelections = [];
    
  $scope.myData= [{name: "Deepu", age: 32, Address: "Address details 1"},
                  {name: "Test1", age: 32, Address: "Address details 1"},
                  {name: "Test2", age: 33, Address: "Address details 29"},
                  ];
$scope.gridOptions = { 
        data: 'myData',
        showFilter: true,
        showColumnMenu: true,
        enableCellSelection: true,
        enableCellEdit: true,   
        showSelectionCheckbox: true,
        selectWithCheckboxOnly: true,
        selectedItems: $scope.mySelections,
        showFooter: true,
        columnDefs: [{field: 'name', displayName: 'Name'}, {field:'age', displayName:'Age'}]
        };
    
  $scope.addItem = function() {
    $scope.myData.push({});
  };
  $scope.allItems = function() {
    var dataLength = $scope.myData.length;    
    alert($scope.myData[dataLength-1].name);
  };
  

  $scope.remove = function () {
    _.each($scope.mySelections, function (person) {
      //Real remove (i.e from datastore)
        $scope.myData = _.filter($scope.myData, function(element){ return element.name != person.name;});
      });
      $scope.mySelections.splice(0, $scope.mySelections.length);
  };  
    
});