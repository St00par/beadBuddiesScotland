function deleteFunc() {
        	let id = document.getElementsByName("f_id")[0].value; 
            fetch("http://localhost:9002/delete/"+id, {  
                method: 'delete'  
              })
              .then((data) => {
                console.log(`Request succeeded with JSON response ${data}`),
            	alert(`Item Deleted!`)
              })
              .catch((error) => {
              
              });
        }