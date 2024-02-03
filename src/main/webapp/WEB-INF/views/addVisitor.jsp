<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page import="repository.entities.VisitorType" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .form-container {
            width: 300px;
            padding: 16px;
            background-color: white;
            margin: 0 auto;
            margin-top: 100px;
            border: 1px solid black;
            border-radius: 4px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
        }
        .form-group input, .form-group select {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        .form-group button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            margin-top: 15px;
            border: none;
            cursor: pointer;
            width: 100%;
        }
        .form-group button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="form-container">
    <form action="addVisitor" method="post" enctype="application/json">
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
        </div>
        <div class="form-group">
            <label for="phone">Phone:</label>
            <input type="text" id="phone" name="phone" required>
        </div>
        <div class="form-group">
            <label for="checkinTime">Check-in Time:</label>
            <input type="date" id="checkinTime" name="checkinTime" pattern="\d{4}/\d{2}/\d{2}" placeholder="yyyy/MM/dd" required>
        </div>
        <div class="form-group">
            <label for="checkoutTime">Check-out Time:</label>
            <input type="date" pattern="\d{4}/\d{2}/\d{2}" placeholder="yyyy/MM/dd" id="checkoutTime" name="checkoutTime" required>
        </div>
        <div class="form-group">
            <label for="duration">Duration:</label>
            <input type="text" id="duration" name="duration" required>
        </div>
        <div class="form-group">
            <label for="purposeOfVisit">Purpose of Visit:</label>
            <input type="text" id="purposeOfVisit" name="purposeOfVisit" required>
        </div>
        <div class="form-group">
            <label for="companyOrOrganization">Company or Organization:</label>
            <input type="text" id="companyOrOrganization" name="companyOrOrganization" required>
        </div>
        <div class="form-group">
            <label for="vehicleNumber">Vehicle Number:</label>
            <input type="text" id="vehicleNumber" name="vehicleNumber" required>
        </div>
        <div class="form-group">
            <label for="visitorType">Visitor Type:</label>
            <select id="visitorType" name="visitorType" required>
                <option value="">Select</option>
                <c:forEach var="visitorType" items="${VisitorType.values()}">
                    <option value="${visitorType}">${visitorType}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <button type="submit">Submit</button>
        </div>
    </form>
</div>