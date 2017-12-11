const api = process.env.REACT_APP_CONTACTS_API_URL || 'http://localhost:8080'
export const fileuploadserv = {
    folderupload,
    sharefolder,
    listfiles,
    deletefile,
    uploadFile,
    starfile,
    folderdata
};
const headers = {
    'Accept': 'application/json'
};
function folderupload(myfolder)
{
    console.log("its folder in fileuploadserv"+myfolder);
    return fetch('http://localhost:8080/folder/createfolder', {
        method: 'POST',
        mode: 'cors',
        credentials: 'include',
        headers: {...headers, 'Content-Type': 'application/json'},
        body: JSON.stringify({myfolder})
    }).then((response) => response.json()).then((responseJson) => {
            return responseJson;
    }).catch(error => {
        console.log("This is error");
        return error;
    });
}
function folderdata(myfolder)
{
    console.log("its folder in fileuploadserv"+myfolder);
    return fetch('http://localhost:8080/folder/getfolderdata', {
        method: 'POST',
        mode: 'cors',
        credentials: 'include',
        headers: {...headers, 'Content-Type': 'application/json'},
        body: JSON.stringify({myfolder})
    }).then((response) => response.json()).then((responseJson) => {
            return responseJson;
    }).catch(error => {
        console.log("This is error");
        return error;
    });
}
function sharefolder(mysharedfolder,sharedemail)
{
    console.log("its sharedfolder in fileuploadserv"+mysharedfolder,sharedemail);
    return fetch(`${api}/folder/sharefolder`, {
        method: 'POST',
        mode:'cors',
        credentials:'include',
        headers: { ...headers,'Content-Type': 'application/json' },
        body: JSON.stringify({mysharedfolder,sharedemail})
    }).then(res => {
        return res.status;
    }).catch(error => {
        console.log("This is error");
        return error;
    });
}
export const getImages = () =>
    fetch(`${api}/folder/`)
        .then(res => res.json())
        .catch(error => {
            console.log("This is error.");
            return error;
        });

function uploadFile(payload) {
console.log(payload);
    return fetch(`${api}/folder/upload`, {
        method: 'POST',
        credentials: 'include',
        mode: 'cors',
        headers: {...headers, 'Content-Type': 'application/json'},
        body: JSON.stringify({payload})
    }).then(res => {
        return res;
    }).catch(error => {
        console.log("This is error");
        return error;
    });
}

function starfile(payload) {
    console.log(payload);
    return fetch(`${api}/folder/starfile`, {
        method: 'POST',
        credentials: 'include',
        mode: 'cors',
        headers: { ...headers,'Content-Type': 'application/json' },
        body: JSON.stringify({payload})
    }).then(res => {
        return res.status;
    }).catch(error => {
        console.log("This is error");
        return error;
    });
}
export const sharefile = (payload,sharing_email) =>
   fetch(`${api}/folder/sharefile`, {
        method: 'POST',
        credentials:'include',
        mode:'cors',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ payload,sharing_email})
    }).then((response) => response.json()).then((responseJson) => {
                return responseJson;
    }).catch(error => {
            console.log("This is error");
            return error;
        });
function listfiles() {
    return fetch(`${api}/folder/listfiles`, {
        method: 'POST',
        credentials: 'include',
        mode: 'cors'
    }).then((response) => response.json()).then((responseJson) => {
        console.log("hii its response JSon" + responseJson);
        return responseJson;
    }).catch(error => {
        console.log("This is error");
        return error;
    });
}
function deletefile(file) {
    return fetch(`${api}/folder/deletefile`, {
        method: 'POST',
        credentials: 'include',
        mode: 'cors',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({file})
    }).then((response) => response.json()).then((responseJson) => {
        return responseJson;
    }).catch(error => {
        console.log("This is error");
        return error;
    });
}