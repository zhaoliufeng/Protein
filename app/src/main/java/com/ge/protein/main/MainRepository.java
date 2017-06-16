/*
 * Copyright 2017 Jiaheng Ge
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ge.protein.main;

import com.ge.protein.data.api.ServiceGenerator;
import com.ge.protein.data.api.service.UserService;
import com.ge.protein.data.model.User;
import com.ge.protein.util.AccountManager;

import io.reactivex.Observable;
import retrofit2.Response;

class MainRepository {

    private UserService userService;

    MainRepository() {
        userService = ServiceGenerator.createService(UserService.class, AccountManager.getInstance().getAccessToken());
    }

    Observable<Response<User>> getMe() {
        return userService.getMe();
    }
}