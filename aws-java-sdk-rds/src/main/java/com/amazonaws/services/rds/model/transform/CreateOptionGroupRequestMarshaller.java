/*
 * Copyright 2010-2016 Amazon.com, Inc. or its affiliates. All Rights
 * Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.amazonaws.services.rds.model.transform;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.DefaultRequest;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.rds.model.*;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.IdempotentUtils;

/**
 * CreateOptionGroupRequest Marshaller
 */

public class CreateOptionGroupRequestMarshaller implements
        Marshaller<Request<CreateOptionGroupRequest>, CreateOptionGroupRequest> {

    public Request<CreateOptionGroupRequest> marshall(
            CreateOptionGroupRequest createOptionGroupRequest) {

        if (createOptionGroupRequest == null) {
            throw new AmazonClientException(
                    "Invalid argument passed to marshall(...)");
        }

        Request<CreateOptionGroupRequest> request = new DefaultRequest<CreateOptionGroupRequest>(
                createOptionGroupRequest, "AmazonRDS");
        request.addParameter("Action", "CreateOptionGroup");
        request.addParameter("Version", "2014-10-31");
        request.setHttpMethod(HttpMethodName.POST);

        if (createOptionGroupRequest.getOptionGroupName() != null) {
            request.addParameter("OptionGroupName", StringUtils
                    .fromString(createOptionGroupRequest.getOptionGroupName()));
        }

        if (createOptionGroupRequest.getEngineName() != null) {
            request.addParameter("EngineName", StringUtils
                    .fromString(createOptionGroupRequest.getEngineName()));
        }

        if (createOptionGroupRequest.getMajorEngineVersion() != null) {
            request.addParameter("MajorEngineVersion", StringUtils
                    .fromString(createOptionGroupRequest
                            .getMajorEngineVersion()));
        }

        if (createOptionGroupRequest.getOptionGroupDescription() != null) {
            request.addParameter("OptionGroupDescription", StringUtils
                    .fromString(createOptionGroupRequest
                            .getOptionGroupDescription()));
        }

        com.amazonaws.internal.SdkInternalList<Tag> tagsList = (com.amazonaws.internal.SdkInternalList<Tag>) createOptionGroupRequest
                .getTags();
        if (!tagsList.isEmpty() || !tagsList.isAutoConstruct()) {
            int tagsListIndex = 1;

            for (Tag tagsListValue : tagsList) {

                if (tagsListValue.getKey() != null) {
                    request.addParameter("Tags.Tag." + tagsListIndex + ".Key",
                            StringUtils.fromString(tagsListValue.getKey()));
                }

                if (tagsListValue.getValue() != null) {
                    request.addParameter(
                            "Tags.Tag." + tagsListIndex + ".Value",
                            StringUtils.fromString(tagsListValue.getValue()));
                }
                tagsListIndex++;
            }
        }

        return request;
    }

}
