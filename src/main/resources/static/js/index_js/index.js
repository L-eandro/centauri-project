let count = 1;
document.getElementById("slide1").checked=true;

setInterval( function(){
nexImage();
},6000)

function nexImage(){
    count++;
    if(count>3){
        count=1;
    }
    document.getElementById("slide"+count).checked=true;
}