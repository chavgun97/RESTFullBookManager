'use strict';
/*Создание контроллера параметры - название - масив - функция которая выполяет весь код
* $scope - это сервис, обьект который мы передаём в контроллер Обеспечивает связь
* модели и вида.
* Что бы контролер зароботал его нужно подключить с помошю ng-controllr = "UserController
* <div ng-controller="MyController>
*     тут параметры $scope
* </div>
**/
App.controller('BookController', ['$scope', 'Book', 'Author', function($scope, Book, Author) {
          var self = this; //сам контроллер
        self.showBookForm = true;
        self.book= new Book (); //обьект который мы передали в функци
        self.author = new Author();
        self.books=[];
        self.authors=[];
        self.space=' ';
              
          self.fetchAllBooks = function(){
        	  self.books = Book.query();
          };
           
          self.createBook = function(){
        	  self.book.$save(function(){
        		  self.fetchAllBooks();
        	  });
          };

          self.updateBook = function(){
        	  self.book.$update(function(){
    			  self.fetchAllBooks();
    		  });
          };

         self.deleteBook = function(identity){
        	 var book = Book.get({id:identity}, function() {
        		  book.$delete(function(){
        			  console.log('Deleting user with id ', identity);
        			  self.fetchAllBooks();
        		  });
        	 });
          };

          self.fetchAllBooks();

          self.submit = function() {
              if(self.book.id==null){
                  console.log('Saving New User', self.book);
                  self.createBook();
              }else{
    			  console.log('Upddating user with id ', self.book.id);
                  self.updateBook();
                  console.log('User updated with id ', self.book.id);
              }
              self.reset();
          };
              
          self.edit = function(id){/*Перебирает лис по айди и если есть такой, заменяет контроллер на новый обьект*/
              console.log('id to be edited', id);
              self.showBookForm = true;
              for(var i = 0; i < self.books.length; i++){
                  if(self.books[i].id === id) {
                      self.book = angular.copy(self.books[i]);
                      break;
                  }
              }

          };
              
          self.remove = function(id){
              console.log('id to be deleted', id);
              if(self.book.id === id) {//If it is the one shown on screen, reset screen
                 self.reset();
              }
              self.deleteBook(id);
          };

          
          self.reset = function(){
              self.book= new Book();
              self.author = new Author();
              self.showBookForm = true;
              $scope.myFormBook.$setPristine(); //reset Form
              $scope.myFormAuthor.$setPristine(); //reset Form

          };

          self.dellAuthor = function(idBook, idAuthor ){
              self.edit(idBook);
              console.log(self.book.id, self.book.title);
            var newAuthors = [];
            var index = 0;
              for(var i = 0; i < self.book.authors.length; i++){
                  if(self.book.authors[i].id!== idAuthor){
                      newAuthors[index]=self.book.authors[i];
                      index++;
                  }
              }
              self.book.authors = newAuthors;
              self.updateBook();
              self.reset();

          };
          self.addAuthor = function (idBook) {
            self.showBookForm = false;
              for(var i = 0; i < self.books.length; i++){
                  if(self.books[i].id === idBook) {
                      self.book = angular.copy(self.books[i]);
                      break;
                  }
              }
            self.authors = Author.query();

          };
          self.addingAuthor = function () {
              var newAuthors = [];
              var index = 0;
              console.log(self.book.authors);/*---------------------------*/
              for(var i = 0; i < self.book.authors.length; i++){
                      newAuthors[i]=self.book.authors[i];
                      index++;
              }
              console.log(newAuthors);/*----------------------------------*/
              self.replaceAuthor();
              newAuthors[index] = self.author;
              self.book.authors = newAuthors;
              console.log(self.book.authors);/*---------------------------*/
              self.updateBook();
              self.reset();
          };
          self.replaceAuthor = function () {
              for(var i = 0; i<self.authors.length; i++){
                  if(self.authors[i].first_name ===self.author.first_name &&
                  self.authors[i].last_name ===self.author.last_name){
                      self.author = self.authors[i];
                      break;
                  }
              }

          }

      }]);
