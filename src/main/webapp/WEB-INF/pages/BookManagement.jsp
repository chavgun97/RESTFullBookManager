<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
    <title>BookManagerAngular</title>
    <style>

    </style>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
     <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>
  </head>
  <body ng-app="myApp" class="ng-cloak">
      <div class="generic-container" ng-controller="BookController as ctrl">   <%--UserControoler теперь просто ctrl--%>
          <div ng-show="ctrl.showBookForm" class="   panel panel-default">
              <div class="panel-heading"><span class="lead">Регистрация книги</span></div>
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="myFormBook" class="form-horizontal"><%--В зависимости от того есть обьект или нету, изменяет его или создаёт--%>
                      <input type="hidden" ng-model="ctrl.book.id" /><%--Берёт обьект для изменения --%>
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="title">Title</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.book.title" id="title" class="bookTitle form-control input-sm" placeholder="Enter title book." required ng-minlength="3"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.bTitle.$error.required">This is a required field</span>
                                      <span ng-show="myForm.bTitle.$error.minlength">Minimum length required is 3</span>
                                      <span ng-show="myForm.bTitle.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                        
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="description">Description</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.book.description" id="description" class="form-control input-sm" placeholder="Enter description of book."/>
                              </div>
                          </div>
                      </div>
                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!ctrl.book.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myFormBook.$invalid">
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myFormBook.$pristine">Reset Form</button>
                          </div>
                      </div>
                  </form>
              </div>
          </div>

          <div ng-hide="ctrl.showBookForm" class="panel panel-default">
              <div class="panel-heading"><span class="lead">Добавление автора</span></div><%--В будущем буду брать значение с обьекта что бы фома менялась--%>
              <div class="formcontainer">
                  <form ng-submit="ctrl.addingAuthor()" name="myFormAuthor" class="form-horizontal"><%--В зависимости от того есть обьект или нету, изменяет его или создаёт--%>
                      <input type="hidden" ng-model="ctrl.author.id" /><%--Берёт обьект для изменения --%>
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="title">FirstName</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.author.first_name" id="first_Name" class="authorName form-control input-sm" placeholder="Enter first name." required ng-minlength="3"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.Aname.$error.required">This is a required field</span>
                                      <span ng-show="myForm.Aname.$error.minlength">Minimum length required is 3</span>
                                      <span ng-show="myForm.Aname.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>


                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="description">Last Name</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.author.last_name" id="last_name" class="form-control input-sm" placeholder="Enter lust name of Author."/>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="Add" class="btn btn-primary btn-sm" ng-disabled="myFormAuthor.$invalid">
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm">Reset Form</button>
                          </div>
                      </div>
                  </form>
              </div>
          </div>


          <div class="panel panel-default">

              <div class="search"><h4>Поиск:</h4><input type="search" ng-model="search" class="form-control input-sm"></div>
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">List of Books </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID</th>
                              <th>Имя</th>
                              <th width = "40%">Описание</th>
                              <th>Авторы</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="b in ctrl.books | filter:search">
                              <td><span ng-bind="b.id"></span></td>
                              <td><span ng-bind="b.title"></span></td>
                              <td><span ng-bind="b.description"></span></td>
                              <td><div ng-repeat="a in b.authors" class="column-box">
                                  <%--<span ng-bind="a.first_name"></span>--%>
                                  <span ng-bind="(a.first_name)+(ctrl.space)+(a.last_name)"></span>
                                  <a type="button" ng-click="ctrl.dellAuthor(b.id,a.id)" class="btn remove"></a>
                              </div>
                              </td>
                              <td>
                                  <button type="button" ng-click="ctrl.addAuthor(b.id)" class="btn btn-success custom-width">Add Auth</button>
                                  <button type="button" ng-click="ctrl.edit(b.id)" class="btn btn-success custom-width">Edit</button>
                                   <button type="button" ng-click="ctrl.remove(b.id)" class="btn btn-danger custom-width">Remove</button>
                              </td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
      
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-resource.js"></script>
      <script src="<c:url value='/static/js/app.js' />"></script>
      <script src="<c:url value='/static/js/service/book_service.js' />"></script>
      <script src="<c:url value='/static/js/controller/book_controller.js' />"></script>
  </body>
</html>