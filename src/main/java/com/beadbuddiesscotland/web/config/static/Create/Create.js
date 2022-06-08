function addFunc() {
    	  let inputType = document.getElementsByName("f_type")[0].value;
          let inputMat = document.getElementsByName("f_material")[0].value;
          let inputCost = document.getElementsByName("f_cost")[0].value;
		  let inputImage = document.getElementsByName("f_image")[0].value;
    	  fetch("http://localhost:9002/create", {
    		    method: 'post', 
    		    headers: {
    		      "Content-type": "application/json"
    		    },
    		    body: JSON.stringify( 
    		      {
    		        "type": inputType,
    		        "material": inputMat,
    		        "cost": inputCost,
					"image": inputImage
    		      }
    		    )
    		  })
    		  .then(res => res.json())
    		  .then((data) => console.log(`Request succeeded with JSON response ${data}`))
    		  .then((data) => alert(`Data Added`))
    		  .catch((error) => console.log(`Request failed ${error}`))
  	}
  