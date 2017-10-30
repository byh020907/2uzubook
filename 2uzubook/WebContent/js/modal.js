$(document).ready(function(){
  var modalLayer = $("#modalLayer");
  var modalLink = $(".modalLink");
  var modalCont = $(".modalContent");
  var marginLeft = modalCont.outerWidth()/2;
  var marginTop = modalCont.outerHeight()/2; 
 
  modalLink.click(function(){
    modalLayer.fadeIn("slow");
    modalCont.css({"margin-top" : -marginTop, "margin-left" : -marginLeft});
    $(this).blur();
    return false;
  });
 
  $(".modalContent > #delete_modal").click(function(){
    modalLayer.fadeOut("slow");
    modalLink.focus();
  });        
});
