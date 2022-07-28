
const getPodsNames = () => {
    return fetch("http://localhost:8080/kkyactus/api/v1/pods")
        .then(response => response.json())
        .then(result => result)
        .catch(error => console.log('error', error));
}

const main = () => {
    getPodsNames().then((pod) => {

        for (let podName of pod) {
            const div = document.createElement("div");
            div.classList.add("kyactus");

            const randomTopPosition = (Math.random() * 300) + 320 + 'px';
            const zeroLeftStart = (Math.random() * 90) + '%';
            const zeroLeftEnd = (Math.random() * 90) + '%';

            div.style.setProperty("--top", randomTopPosition)
            div.style.setProperty('--zeroLeftStart', zeroLeftStart);
            div.style.setProperty('--zeroLeftEnd', zeroLeftEnd);

            const p = document.createElement("p");
            p.classList.add("podname")
            p.innerText = podName
            div.appendChild(p);

            const image = document.createElement("img")
            image.setAttribute("src", "./img/cactuar.png");
            image.setAttribute("height", "80px");
            image.setAttribute("width", "80px");

            div.appendChild(image);
            document.body.appendChild(div)
        }

    })
}

main();