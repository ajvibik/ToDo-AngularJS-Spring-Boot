var app = angular.module('ToDoApp', []);
app.controller('ToDoCtrl', TodoCtrl);
function TodoCtrl($scope, $http) {
    $scope.newToDo = "";

    $scope.getAllTodos = function () {
        $http.get("http://localhost:8080/todo")
            .then(function (response) {
                $scope.todos = response.data;

            }, function (response) {
                $scope.content = "Something went wrong";
            });

    };

    $scope.addTodo = function (newToDo) {
        if (newToDo) {
            var data = {
                "text": newToDo,
                "done": false
            }
            $http.post("http://localhost:8080/todo", data)
                .then(function (response) {
                    $scope.content = response.data;
                    $scope.getAllTodos();
                }, function (response) {
                    $scope.content = "Something went wrong";
                });
        }
    };

    $scope.deleteToDo = function (item) {
        $http.delete("http://localhost:8080/todo/" + item.id)
            .then(function (response) {
                $scope.content = response.data;
                $scope.getAllTodos();
            }, function (response) {
                $scope.content = "Something went wrong";
            });
    };

    $scope.AddToCompleted = function (item) {
        var data = {
            "text": item.text,
            "done": true
        }
        $http.put("http://localhost:8080/todo/" + item.id, data)
            .then(function (response) {
                $scope.compledTodos = response.data;
                $scope.getAllTodos();
            }, function (response) {
                $scope.content = "Something went wrong";
            });
    };
};
