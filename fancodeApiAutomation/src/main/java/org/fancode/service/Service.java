package org.fancode.service;

import io.qameta.allure.Step;

import java.util.List;
import java.util.Objects;

public interface Service<T> {

    T[] getAll();
}
