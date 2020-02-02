
*** Settings ***
Library     Collections
Library     RequestsLibrary

*** Test Cases ***
Github 接口的返回值应该是 200 OK
    Create Session         github  http://api.github.com
    ${resp}=               Get Request  github  /users/wizardbyron
    Should Be Equal As Strings  ${resp.status_code}    200 
