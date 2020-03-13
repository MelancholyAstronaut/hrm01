var Lock = function () {
    var pathName = document.location.pathname;
    var result = pathName.substr(0,   1);

    return {
        //main function to initiate the module
        init: function () {
            $.backstretch([
                result + "js/metronic/img/bg/1.jpg",
                result + "js/metronic/img/bg/2.jpg",
                result + "js/metronic/img/bg/3.jpg",
                result + "js/metronic/img/bg/4.jpg"
            ], {
                fade: 1000,
                duration: 10*1000
            });
        }

    };

}();