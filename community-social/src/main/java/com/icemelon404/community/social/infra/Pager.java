package com.icemelon404.community.social.infra;

import com.icemelon404.community.commons.dto.ConcretePagedRequest;

public class Pager {

    public Boundary getPage(ConcretePagedRequest request, int max) {
        int low = max / request.getTotalPage() * request.getRequestPage();
        int maxPageIdx = request.getTotalPage() - 1;
        if (request.getRequestPage() == maxPageIdx)
            return new Boundary(low, max);
        int high = max / request.getTotalPage() * (request.getRequestPage() + 1);
        return new Boundary(low, high);
    }
}
