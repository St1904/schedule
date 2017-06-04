/**
 * Created by sbt-sokolova-ts on 13.02.2017.
 */
$(document).ready(function() {
    $.ajax({
        type: "GET",
        datatype: "json",
        url: "/rest/contactname"
    }).then(function(data) {
        $('.contact-id').append(data.id);
        $('.contact-name').append(data.name);
    });
});