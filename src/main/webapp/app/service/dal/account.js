"use strict";

(function () {

    function AccountDal (dal) {

        this.getAccounts = function () {
            return dal.http.GET("api/account/json");
        };

        this.saveAccount = function (accountToSave) {
            return dal.http.POST("api/account/json", accountToSave);
        };

        this.updateAccount = function (accountToUpdate) {
            return dal.http.PUT("api/account/json/", accountToUpdate);
        };

        this.deleteAccount = function (accountToDelete) {
            return dal.http.DELETE("api/account/json/", accountToDelete);
        };
    }
    
    angular.module("accountApp").service("accountDal", ["dal", AccountDal]);
}());