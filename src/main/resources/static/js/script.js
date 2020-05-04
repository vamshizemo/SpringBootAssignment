var taskForm = document.getElementById("taskform");
var inputTask=document.getElementById("intask");
var cbox=document.getElementById("cbox");
var resForm=document.getElementById("result");

function getButton(id,value){
    let button = document.createElement("input");
    button.setAttribute("type", "submit");
    button.setAttribute("id", id);
    button.value=value;
    return button;
}
var buttona = getButton("top","Add Task");
var inputValue;

inputTask.onkeypress =  function(){
    inputValue = inputTask.value;
    if(inputValue.trim()!=null){
        taskForm.appendChild(buttona);
    }else{
        window.alert("no text");
        taskForm.removeChild(button);
    }
}
button1=getButton("first","Delete Task");
cbox.onclick=function(){
    if(cbox.checked){resForm.appendChild(button1);}
    else{resForm.removeChild(button1);}

}
