# credit-front

> A Vue.js project

## Build Setup

``` bash
# install dependencies
npm install

# serve with hot reload at localhost:8080
npm run dev

# build for production with minification
npm run build

# build for production and view the bundle analyzer report
npm run build --report

# run unit tests
npm run unit

# run e2e tests
npm run e2e

# run all tests
npm test
```

For a detailed explanation on how things work, check out the [guide](http://vuejs-templates.github.io/webpack/) and [docs for vue-loader](http://vuejs.github.io/vue-loader).


```bash
docker build -t palexu/credit-front .

将docker内部的 80 映射到外部的 8080 ，在外部访问 8080 即可访问
docker run --name=front -d -p 8080:80 palexu/credit-front:latest

docker rm front

docker stop front
```
