$(document).ready(function () {

    $("#search-form").submit(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();
        var requestjson = "<h4>LCS Request</h4>"
            + $("#setofstrings").val();
        $('#lcsrequest').html(requestjson);

// Manual submit
        post_ajax_submit();

    });

});

function post_ajax_submit() {

    var search = {}
  
//window.alert($("#setofstrings").val());

    $("#btn-search").prop("disabled", true);
    
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/lcs",
        data: $("#setofstrings").val(),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
        	
            var json = "<h4>LCS Response</h4>"
                + JSON.stringify(data, null, 4);
            $('#feedback').html(json);
//window.alert(data);
            console.log("SUCCESS : ", data);
            $("#btn-search").prop("disabled", false);

        },
        error: function (e) {

            var json = "<h4>LCS Response</h4>"
                + e.responseText;
            $('#feedback').html(json);
// window.alert(e);
            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", false);

        }
    });

}