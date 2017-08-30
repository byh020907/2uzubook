$(function(){
	$("#licence").click(function(){
		var $e = $("#licence_div ul li:last").clone();
	    $e.find("input").val("");
	    $("#licence_div ul").append($e);
	})
	$("#attend").click(function(){
		var $e = $("#attend_div ul li:last").clone();
	    $e.find("input").val("");
	    $("#attend_div ul").append($e);
	})
	$("#award").click(function(){
		var $e = $("#award_div ul li:last").clone();
	    $e.find("input").val("");
	    $("#award_div ul").append($e);
	})
	$("#project").click(function(){
		var $e = $("#project_div ul li:first").clone();
	    $e.find("input").val("");
	    $("#project_div ul").append($e);
	})
	$("#club").click(function(){
		var $e = $("#project_div ul li:nth-child(2)").clone();
	    $e.find("input").val("");
	    $("#project_div ul").append($e);
	})
	$("#Volunteer").click(function(){
		var $e = $("#etc_div ul li:first").clone();
	    $e.find("input").val("");
	    $("#etc_div ul").append($e);
	})
	$("#Book").click(function(){
		var $e = $("#etc_div ul li:nth-child(2)").clone();
	    $e.find("input").val("");
	    $("#etc_div ul").append($e);
	})
	$("#Hobby").click(function(){
		var $e = $("#etc_div ul li:nth-child(3)").clone();
	    $e.find("input").val("");
	    $("#etc_div ul").append($e);
	})
})


		