import React from "react";
import '../index.css';

class About extends React.Component{
    render() {
        return(
            <section class="page-section bg-primary" id="about">
            <div class="container px-4 px-lg-5">
                <div class="row gx-4 gx-lg-5 justify-content-center">
                    <div class="col-lg-8 text-center">
                        <h2 class="text-white mt-0">What is it?</h2>
                        <hr class="divider divider-light" />
                        <p class="text-white-75 mb-4"><i>Out of Milk</i> is a web service designed for residents of a living space who are roommates. This service will allow for all roommates to be added to a group, where they will be able to add kitchen items and the amount they have. Then, as the group uses these items during their day to day, they would signify how much of the item they have used. When an item falls below a certain amount set by the group, a notification would be sent out to alert this so that the group knows to go out and buy more. For example, if the amount of sponges the group has falls below two, an alert would be sent out stating this.</p>
                        <a class="btn btn-light btn-xl" href="#services">What's so great?</a>
                    </div>
                </div>
            </div>
        </section>
        );

    }
}

export default About;