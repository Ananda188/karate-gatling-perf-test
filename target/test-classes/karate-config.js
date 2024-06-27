

function fn() {
    var env = karate.env
    karate.log('Environment is: ', env);
  var config = {
    env: env,
    myVarName: 'someValue',
    baseUrl: 'https://reqres.in/'

  };

  return config;
}