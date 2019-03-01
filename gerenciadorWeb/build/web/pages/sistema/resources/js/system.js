(function ($) {
    "use strict"; // Start of use strict

    // Toggle the side navigation
    $("#sidebarToggle").on('click', function (e) {
        e.preventDefault();
        $("body").toggleClass("sidebar-toggled");
        $(".sidebar").toggleClass("toggled");
    });

    // Prevent the content wrapper from scrolling when the fixed side navigation hovered over
    $('body.fixed-nav .sidebar').on('mousewheel DOMMouseScroll wheel', function (e) {
        if ($(window).width() > 768) {
            var e0 = e.originalEvent,
                    delta = e0.wheelDelta || -e0.detail;
            this.scrollTop += (delta < 0 ? 1 : -1) * 30;
            e.preventDefault();
        }
    });

    // Scroll to top button appear
    $(document).on('scroll', function () {
        var scrollDistance = $(this).scrollTop();
        if (scrollDistance > 100) {
            $('.scroll-to-top').fadeIn();
        } else {
            $('.scroll-to-top').fadeOut();
        }
    });

    // Smooth scrolling using jQuery easing
    $(document).on('click', 'a.scroll-to-top', function (event) {
        var $anchor = $(this);
        $('html, body').stop().animate({
            scrollTop: ($($anchor.attr('href')).offset().top)
        }, 1000, 'easeInOutExpo');
        event.preventDefault();
    });

    $(document).on('change', function (event) {
        let element = event.target;
        if (element && element.matches(".form-element-field")) {
            element.classList[element.value ? "add" : "remove"]("-hasvalue");
        }
    });

    $(document).ready(function () {
        selectElementVerify();
        calcStep();
        activeNavItem();
    });





})(jQuery); // End of use strict

function selectElementVerify() {
    var element = document.getElementsByTagName('select');
    if (element.length > 0) {

        for (var i = 0, max = element.length; i < max; i++) {
            if (element[i] && element[i].matches(".form-element-field")) {
                element[i].classList[element[i].value ? "add" : "remove"]("-hasvalue");
            }
        }
    }
}

function calcStep() {
    var elem = $('div.arrow-steps');
    var currentValue = $(elem).attr('currentValue');
    var i = 0;
    $(elem).find('div.step').each(function (){
         if(i == currentValue){
            $(this).addClass('current');
        }else if(i < currentValue){
            $(this).addClass('done');
        }
        i++;
    });
}

function activeNavItem(){
    var nav = 0;
    var navNum = returnNavNum();
    var elem = $('.navbar-nav');
    $(elem).find('.nav-item').each(function (){
        if(nav === navNum){
            $(this).addClass('active');
        }
        nav++;
    });
}

function returnNavNum(){
    var formName = $('#content-wrapper form').attr('id');
    if(formName.includes('Imoveis')){
        return 1;
    } else if(formName.includes('Processos')){
        return 2;
    } else if(formName.includes('Obras')){
        return 3;
    } else if(formName.includes('Condominio')){
        return 4;
    }
}