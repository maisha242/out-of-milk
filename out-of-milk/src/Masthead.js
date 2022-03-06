import './index.css';
import React from "react";

export class masthead extends React.Component{
    constructor(props) {
        super(props);

        this.state = {value: ''}
    }


    render() {
        return(
            <header class="masthead">
            <div class="container px-4 px-lg-5 h-100">
                <div class="row gx-4 gx-lg-5 h-100 align-items-center justify-content-center text-center">
                    <div class="col-lg-8 align-self-end">
                        <h1 class="text-white font-weight-bold">For All Your Kitchen Inventory Management Needs!</h1>
                        <hr class="divider" />
                    </div>
                    <div class="col-lg-8 align-self-baseline">
                        <p class="text-white-75 mb-5">Add your roommates to your group so you all are able to look at what you have in your kitchen and how much of it you have left!</p>
                        <a class="btn btn-primary btn-xl" href="#about">Find Out More</a>
                    </div>
                </div>
            </div>
        </header>
        );

    }
}

export default masthead;