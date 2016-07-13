$(document).ready(function(){
    $('#turn_button').click(function (){
        var keyword = $('#keyword').val();
        console.log(keyword);
        ajaxSendRequest(keyword);
    });
});

function ajaxSendRequest(keyword) {
    $.ajax
    ({
        type: "POST",
        url: './task/turn',
        dataType: 'json',
        async: false,
        //json object to sent to the authentication url
        data: JSON.stringify({ "keyword": keyword }),
        success: function (data) {
            console.log(data);
            var str_json = JSON.stringify(data);
            var json = JSON.parse(str_json);
            alert(json.response);
        },
        error: function () {
            alert("Bad!");
        }
    })
}