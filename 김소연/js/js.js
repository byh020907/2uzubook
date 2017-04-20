var count=0;
$("#upload").click(function(){
   var input= $('#inputBox').val()
   
   $("#content").append(
   $("<div id='article" + count + "' class='article'>" +count + ". " + input + "<br><input id='commentBox" + count + "'>" +
    "<button onclick='comment(" + count + ")'> 댓글 올리기</button>"+
     "</div>"))
   $('#inputBox').val("");
       count++;
});


    
    
    
function comment(count){
   $("#article"+count).append(
       $("<div class='comment'>"+$('#commentBox'+count).val()+"</div>"));
    $('#commentBox'+count).val("");
    
}