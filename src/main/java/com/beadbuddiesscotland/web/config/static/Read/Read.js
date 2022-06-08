/*function readFunc() {*/
/*        fetch("http://localhost:9002/getAll") 
            .then((response) => {
                return response.json();
            })
            .then((data) => {
                console.log(data);
                let div = document.querySelector('.main');
                const furniture = data;
                const furnitureContainer = document.createElement('div');
                div.appendChild(furnitureContainer);
                furniture.forEach((item) => {
                console.log(item)
                const pId = document.createElement("p");
                const pType = document.createElement("p");
                const pMaterial = document.createElement("p");
                const pCost = document.createElement("p");
                pId.innerText = item.id;
                pType.innerText = item.type;
                pMaterial.innerText = item.material;
                pCost.innerText = item.cost;
                furnitureContainer.appendChild(pId);
                furnitureContainer.appendChild(pType);
                furnitureContainer.appendChild(pMaterial);
                furnitureContainer.appendChild(pCost);
                });
                div.appendChild(furnitureContainer);
                })
                .catch((error) => console.log(error));
            } */ 

axios({

	method: 'get',
	url: `http://localhost:9002/getAll`

})

            .then((res) => generateJewelleryCard(res.data))
			.catch(error => console.log(error))

function generateJewelleryCard(data) {
	console.log(data);
	for (let i = 0; i < data.length; i++) {
  let topicCard = document.getElementById(`jewelleryCard`);
  topicCard.innerHTML +=
    `
  <div class="card col-12 mt-3 p-0 mobile">
    <div class="col-12">
	    <h2>${data[i].type}</h2>
		<p>${data[i].image}</p>
      	<p>Material(s):${data[i].material}</p>
		<p>Cost: £${data[i].cost}</p>                          
    </div>
  </div>
  `
}
}
