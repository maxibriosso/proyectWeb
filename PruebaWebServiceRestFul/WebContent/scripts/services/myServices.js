 angular.module('pruebaAngularApp')
   .factory('dataFactory', ['$http', function($http) {
    var dataFactory = {};

    console.log(dataFactory);
    dataFactory.insertUser = function (datos) {

            console.log(datos);
            return $http.post('http://localhost:8080/PruebaWebServiceRestFul/rest/UsuarioService/usuario', datos);

        };

    dataFactory.getStatus = function () {

            
            return $http.get('http://localhost:8080/PruebaWebServiceRestFul/rest/UsuarioService/status/');

        };
        
     dataFactory.getUsuario = function (nombre) {

    	    console.log(nombre);
            return $http.get('http://localhost:8080/PruebaWebServiceRestFul/rest/UsuarioService/usuarioPrueba/'+nombre );

        };
    /* var urlBase = '/api/customers';
    var dataFactory = {};

    dataFactory.getUsers = function () {
        return $http.get(urlBase);
    };

    dataFactory.getUser = function (id) {
        return $http.get(urlBase + '/' + id);
    };

    dataFactory.insertUser = function (user) {
        return $http.post(urlBase, user);
    };

    dataFactory.updateUser = function (user) {
        return $http.put(urlBase + '/' + user.ID, user)
    };

    dataFactory.deleteUser = function (id) {
        return $http.delete(urlBase + '/' + id);
    };
*/
   

    return dataFactory;
}]); 