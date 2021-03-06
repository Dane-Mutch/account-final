"use strict";

(function() {

    var AccountController =  function(accountService, $log) {
        
    	var vm = this;
        
        vm.isHidden = false;
        
        vm.hideTable = function()
        {
        	vm.isHidden = !vm.isHidden
        };
        
        function init() {
        	accountService.getAccounts().then(function (results) {
           	vm.accounts = results;
           	$log.log("In the account controller the value of the result promise is ");
        	$log.log(JSON.stringify(vm.accounts));
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
       }

       function addAccount() {
        
            accountService.saveAccount();
       }
       
       init();
            
    };

    angular.module('accountApp').controller('accountController', ['accountService','$log', AccountController]);
}());