
window.onload = function(){
    var input = document.getElementsByTagName("input");
    console.log(input);
    for(let i=0 ; i<input.length - 1 ; i++){
        input[i].oninput = ()=>{
            input[i].setCustomValidity("");
        }
        
        input[i].oninvalid = () =>{
            if(!input[i].valid){
                console.log("run");
                input[i].setCustomValidity("Vui lòng không bỏ trống");
            }
        };
    }
};
console.log("ss");
