import axios, { AxiosError, AxiosRequestConfig, AxiosResponse } from 'axios';

interface IInitAxios {
    (token: string): void;
}

export const configAxios: IInitAxios = (token) => {
    axios.defaults.baseURL = process.env.REACT_APP_PATH_ENDPOINT;

    const responseHandler = (response: AxiosResponse) => response;
    const errorHandler = (error: AxiosError) => {
        if(error.response) responseHandler(error.response);

        return Promise.reject(error);
    }

    const requestHandler = (request: AxiosRequestConfig) => {

        if(!request.headers) request.headers = {};
        request.headers['Authorization-FB'] = token;

        return request;
    }

    axios.interceptors.request.use(requestHandler);
    axios.interceptors.response.use(responseHandler, errorHandler);
}