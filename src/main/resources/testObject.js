/**
 * Created by shivparmar01 on 24-02-2016.
 */

var task = new Object();// create a new object, it have other method too for creating object
task.title = "My Task";
task.description = "My Description";
task.toString = function() {
    return task.title + ' ' + this.description;
};
console.log(task.toString());

var anotherTask = {
    title : "title kuchh bhi",
    description : "this one description"
}
console.log(anotherTask.description);

Object.defineProperty(task, 'toString', {
    value : function() {
        return this.title + " , " + this.description;
    },
    writable : false, // we can not change value of the property like task.title="something else"
    enumerable : false, // if it is true then it print properties in array manner including toString
    configurable : false
// we can not overload this property but we can override
});
//Object.defineProperty(task, 'toString', {
//    enumerable : true
//});
//task.toString = 'hi';

var urgentTask = Object.create(task); // showing inheritance how we can override toString function even it is not configurable.
Object.defineProperty(urgentTask, 'toString', {
    value : function() {
        return this.title + " is urgent task";
    },
    writable : false,
    enumerable : false,
    configurable : false
});
console.log(urgentTask.toString());// printing object on console

// creating constructor function

var Task = function(param1, param2) {
    this.title = param1;
    this.description = param2;
    this.completed = false;
    this.toString = function() {
        return this.title + " ,  " + this.description;
    }
}
Task.prototype.complete= function(){
    console.log('completing task: ' + task.title);
    this.completed = true;
}
Task.prototype.save= function(){
    console.log('saving task: ' + this.title)
}

var task1= new Task("create a demo for constructors" , "this is example of Object");
var task2 = new Task("create demo for singleton","description");
var task3 = new Task("crate demo for modules","description");
var task5 = new Task("create demo for prototype","description");
var task4 = new Task("create a fake task","description");

task1.complete();
task2.save();
task3.save();
task4.save();
task5.complete();

