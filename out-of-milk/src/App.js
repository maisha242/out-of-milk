import React from 'react'
import './App.css';
import Navbarbrand from '../src/components/Navbarbrand.js';
import Masthead from '../src/components/Masthead.js';
import About from '../src/components/About.js';

class App extends React.Component {

  render() {
    return (
      <div className="App">
        <body>
          <Navbarbrand></Navbarbrand>
          <Masthead></Masthead>
          <About></About>

        <footer class="bg-light py-5">
            <div class="container px-4 px-lg-5"><div class="small text-center text-muted">2022, BrickHack 8 - Maisha Iqbal, Jabrecia Washington, Roshan Nunna, Tyler Garcia</div></div>
        </footer>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.js"></script>
        <script src="outofmilk.js"></script>

        <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
        </body>
        
  
      </div>
      
    );
  };
}

export default App;
