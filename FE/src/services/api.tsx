import axios from "axios";
import React from "react";
let configValue : string | undefined  = process.env.REACT_APP_API

export const getSuppliers = async () => { 
    return await axios.get(`http://localhost:8080/api/suppliers/findAll`)
}
export const createSupplier = async (supplier:object)=>{
    return axios.post(`http://localhost:8080/api/suppliers`,supplier)
}
export const deleteSupplier = async (listId:React.Key[])=>{
    return axios.put(`http://localhost:8080/api/suppliers/delete`,listId)
}
export const updateStatusSupplier = async (listId:React.Key[],status:string)=>{
    return axios.put(`http://localhost:8080/api/suppliers/updateStatus/${status}`,listId)
}
export const updateSupplier = async (supplier:object)=>{
    return axios.put(`http://localhost:8080/api/suppliers`,supplier)
}
export const getSupplierById = async (id:number) => {   
    return await axios.get(`http://localhost:8080/api/suppliers/${id}`)
}

export const getProvince = async () =>{
    return await axios.get(`https://provinces.open-api.vn/api/p`)
}

export const getDistrict= async (code:string) =>{
    return await axios.get(`https://provinces.open-api.vn/api/p/${code}?depth=2`)
}
export const getWard= async (code:string) =>{
    return await axios.get(`https://provinces.open-api.vn/api/d/${code}?depth=2`)
}

export const getProductVariant = async (pageNumber:number) => {
    return await axios.get(`http://localhost:8080/api/product-variants/findProductVariant?pageNumber=${pageNumber}&pageSize=5`)
}
export const getCountTotalProductVariant = async () => {
    return await axios.get(`http://localhost:8080/api/product-variants/count-total`)
}