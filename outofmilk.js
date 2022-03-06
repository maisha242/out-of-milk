/*!
* Start Bootstrap - Creative v7.0.5 (https://startbootstrap.com/theme/creative)
* Copyright 2013-2021 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-creative/blob/master/LICENSE)
*/
//
// Scripts
// 

window.onload = function () {
    document.querySelector("#confirm").onclick = ConfirmButtonClicked;
    //document.querySelector("#container").innerHTML = "";
}

window.addEventListener('DOMContentLoaded', event => {

    // Navbar shrink function
    var navbarShrink = function () {
        const navbarCollapsible = document.body.querySelector('#mainNav');
        if (!navbarCollapsible) {
            return;
        }
        if (window.scrollY === 0) {
            navbarCollapsible.classList.remove('navbar-shrink')
        } else {
            navbarCollapsible.classList.add('navbar-shrink')
        }

    };

    // Shrink the navbar 
    navbarShrink();

    // Shrink the navbar when page is scrolled
    document.addEventListener('scroll', navbarShrink);

    // Activate Bootstrap scrollspy on the main nav element
    const mainNav = document.body.querySelector('#mainNav');
    if (mainNav) {
        new bootstrap.ScrollSpy(document.body, {
            target: '#mainNav',
            offset: 74,
        });
    };

    // Collapse responsive navbar when toggler is visible
    const navbarToggler = document.body.querySelector('.navbar-toggler');
    const responsiveNavItems = [].slice.call(
        document.querySelectorAll('#navbarResponsive .nav-link')
    );
    responsiveNavItems.map(function (responsiveNavItem) {
        responsiveNavItem.addEventListener('click', () => {
            if (window.getComputedStyle(navbarToggler).display !== 'none') {
                navbarToggler.click();
            }
        });
    });

    // Activate SimpleLightbox plugin for portfolio items
    new SimpleLightbox({
        elements: '#item a.portfolio-box'
    });

});


function ConfirmButtonClicked() {

    // The item to be added
    let item = document.querySelector("#item").value;
    // The amount of the item
    let amount = document.querySelector("#starting-number").value;
    // The date the item was purchased
    let date = document.querySelector("#date").value;

    let bigString = document.querySelector("#container").innerHTML;

    bigString += "<div class='item-box-caption'>";
    bigString += `<div class='item-info'>Item:&nbsp;${item}&nbsp;&nbsp;&nbsp;&nbsp;Amount Left:&nbsp;${amount}&nbsp;&nbsp;&nbsp;&nbsp;Date Purchased:&nbsp;${date}</div>`;
    bigString += '</div>';
    bigString += "<br>";

    document.querySelector("#container").innerHTML = bigString;

}